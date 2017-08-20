package twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import twitter4j.QueryResult;
import twitter4j.Status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TweetsService {

    private static final Integer OPERATION_CALL_TWITTER_COUNT = 25;

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
                    int size = queryResult.get().getTweets().size() - 1;
                    if (queryResult.get().getTweets().get(size).getCreatedAt().getTime() >= twentyHoursAgo.getTime()) {
                        if (!CollectionUtils.isEmpty(queryResult.get().getTweets()) && queryResult.get().getTweets().size() > 1) {
                            lastTwitsId = queryResult.get().getTweets().get(size).getId();
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
            for (int element = 0; element < tweetsList.size() - 1; ) {
                int nextElement = element + 1;
                if (tweetsList.get(element).getCreatedAt().getHours() != tweetsList.get(nextElement).getCreatedAt().getHours()) {
                    if (tweetList.contains(tweetsList.get(element))) {
                        putValueInMapAndCleanList(tweetsMap, tweetList);
                    } else {
                        tweetList.add(tweetsList.get(element));
                        putValueInMapAndCleanList(tweetsMap, tweetList);
                    }
                    element++;
                } else {
                    tweetList.add(tweetsList.get(element));
                    element++;
                }
            }
        }
        return tweetsMap;
    }

    private void putValueInMapAndCleanList(Map<String, Integer> tweetsMap, List<Status> tweetList) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(tweetList.get(0).getCreatedAt());
        tweetsMap.put(date + " (" + tweetList.get(0).getCreatedAt().getHours() + ":00" + " - " + (tweetList.get(0).getCreatedAt().getHours() + 1) + ":00)", tweetList.size());
        tweetList.clear();
    }

}
