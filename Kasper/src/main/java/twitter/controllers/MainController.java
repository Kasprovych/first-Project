package twitter.controllers;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import twitter.service.SearchTweets;
import twitter.service.TweetsService;
import twitter4j.QueryResult;
import twitter4j.Status;

import java.util.*;

@Controller
@RequestMapping("/")
public class MainController {

    public static final String HASHTAG = "%23";

    private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Autowired
    private TweetsService tweetsService;

    @Inject
    public MainController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String getPage(final Model model, @ModelAttribute("hashtag") final String hashtag) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }
        final Map<String, Integer> tweetsMap = tweetsService.getTweetsMap(tweetsService.getTweetsList(hashtag));
        model.addAttribute("timeMap", tweetsMap);
        return "hashtag";
    }

    @PostMapping
    public String findTweets(final Model model, @RequestParam(value = "hashtag", required = true) final String hashtag, final RedirectAttributes redirectAttribute) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }
        if(hashtag.contains("#")){
            redirectAttribute.addAttribute("hashtag", hashtag);
        }else{
            redirectAttribute.addAttribute("hashtag", HASHTAG + hashtag);
        }

        return "redirect:/";
    }

}
