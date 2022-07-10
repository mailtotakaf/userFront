package userDataFront;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UserFrontController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * ユーザ一覧表示
     */
    @GetMapping("/getUserList")
    public String index(Model model) {
        // userApi
        ResponseEntity<List<UserData>> response = restTemplate.exchange(
                "http://localhost:8081/getUserList", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<UserData>>() {
                });
        List<UserData> userDataList = response.getBody();

        model.addAttribute("userDataList", userDataList);
        return "index";
    }

}
