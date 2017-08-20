package twitter.service;

import org.springframework.stereotype.Service;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class ConfigurationService {
    private static final String CONSUMER_KEY = "sKzFWtpnxWKmNg7NuDvvBN5AL";
    private static final String CONSUMER_SECRET = "RYfxclGDlmZobEw2qXFJWmjKsFMiLORXINT81ncBOhwRvgNXVB";
    private static final String ACCESS_TOKEN = "2453860070-I5oTfInIYKyCnyiiv8RcMxkPRnF2jP2lBl6uGcb";
    private static final String ACCESS_TOKEN_SECRET = "EJM32AhIV1XKEZUSuPcTdp3rHIIr87fJCRYcyY5WrnOiy";

    public ConfigurationBuilder getConfiguration() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        return builder;
    }
}
