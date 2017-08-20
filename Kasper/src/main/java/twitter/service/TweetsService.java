package twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import twitter4j.QueryResult;
import twitter4j.Status;

import java.util.*;

@Service
public class TweetsService {

    public static final Integer OPERATION_CALL_TWITTER_COUNT = 25;
    public static final Integer HOUR_IN_DAY = 24;

    @Autowired
    private SearchTweets searchTweets;

    public List<Status> getTweetsList(final String hashtag) {
        Optional<QueryResult> queryResult = null;
        List<Status> tweetsList = new ArrayList<>();
        Date twentyHoursAgo = new Date();
        twentyHoursAgo.setDate(twentyHoursAgo.getDay() - 1);
        long lastTwitsId = 0l;
        for (int count = 0; count < OPERATION_CALL_TWITTER_COUNT; count++) {
            if (!StringUtils.isEmpty(hashtag)) {
                queryResult = searchTweets.searchTweets(hashtag, lastTwitsId);
                if (queryResult.isPresent()) {
                    if (queryResult.get().getTweets().get(queryResult.get().getTweets().size() - 1).getCreatedAt().getTime() >= twentyHoursAgo.getTime()) {
                        if (!CollectionUtils.isEmpty(queryResult.get().getTweets()) && queryResult.get().getTweets().size() > 1) {
                            lastTwitsId = queryResult.get().getTweets().get(queryResult.get().getTweets().size() - 1).getId();
                            tweetsList.addAll(queryResult.get().getTweets());
                        }
                    }
                }
            }
        }
        return tweetsList;
    }

    public Map<String, Integer> getTweetsMap(List<Status> tweetsList) {
        Map<String, Integer> tweetsMap = new LinkedHashMap<>();
        if (!CollectionUtils.isEmpty(tweetsList)) {
            List<Status> tweetList = new ArrayList<>();
            for (int first = 0; first < tweetsList.size() - 1; ) {
                if (tweetsList.get(first).getCreatedAt().getHours() != tweetsList.get(first + 1).getCreatedAt().getHours()) {
                    if (tweetList.contains(tweetsList.get(first))) {
                        putAndCleanMap(tweetsMap, tweetList);
                    } else {
                        tweetList.add(tweetsList.get(first));
                        putAndCleanMap(tweetsMap, tweetList);
                    }
                    first++;
                } else {
                    tweetList.add(tweetsList.get(first));
                    first++;
                }
            }
        }
        return tweetsMap;
    }

    private void putAndCleanMap(Map<String, Integer> tweetsMap, List<Status> tweetList) {
        tweetsMap.put(tweetList.get(0).getCreatedAt().getHours() + ":00" + " - " + (tweetList.get(0).getCreatedAt().getHours() + 1) + ":00", tweetList.size());
        tweetList.clear();
    }

}
