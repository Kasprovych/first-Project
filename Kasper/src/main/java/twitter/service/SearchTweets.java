package twitter.service;

/**
 * Created by olehstefaniv on 19.08.17.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.QueryResult;
import twitter4j.Query;
import twitter4j.TwitterException;

import java.time.LocalDate;
import java.util.Optional;


@Component
public class SearchTweets {

    private static final Logger LOG = LoggerFactory.getLogger(SearchTweets.class);

    @Autowired
    private ConfigurationService configurationService;

    public Optional<QueryResult> searchTweets(final String hashtag, Long lastTwitId) {
        try {
            TwitterFactory tf = new TwitterFactory(configurationService.getConfiguration().build());
            Twitter twitter = tf.getInstance();
            Query query = new Query(hashtag);
            query.count(100);
            LocalDate dayBefore = LocalDate.now();
            query.setSince(dayBefore.minusDays(1).toString());
            if (lastTwitId != 0l) {
                query.setMaxId(lastTwitId);
            }
            QueryResult result = twitter.search(query);
            if (result.getCount() == 0) {
                LOG.warn("No tweets with hashtag: {} ", hashtag);
                return Optional.empty();
            }
            return Optional.of(result);

        } catch (TwitterException te) {
            te.printStackTrace();
            LOG.warn("Failed to search tweets with hashtag {} ", hashtag);
            return Optional.empty();
        }
    }
}