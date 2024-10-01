package hr.tvz.zr.menzastudent.controller;

import hr.tvz.zr.menzastudent.model.*;
import hr.tvz.zr.menzastudent.service.AuthenticationService;
import hr.tvz.zr.menzastudent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("menza-app")
public class UserController {
    private UserService userService;
    private AuthenticationService authenticationService;

    @PostMapping("login")
    public ResponseEntity<UserAuthResponse> userLogin(@RequestBody UserAuthRequest userAuthRequest){
        return new ResponseEntity<>(authenticationService.authenticate(userAuthRequest), HttpStatus.OK);
    }

    @PostMapping("signup")
    public ResponseEntity<ResponseRequest> userSignUp(@RequestBody SignUpRequest signUpRequest){
        ResponseRequest responseRequest = new ResponseRequest();
        responseRequest.setResponse(authenticationService.signUp(signUpRequest));
        return new ResponseEntity<>(responseRequest, HttpStatus.CREATED);
    }

    @PostMapping("/refresh")
    public ResponseEntity<UserAuthResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return new ResponseEntity<>(authenticationService.refreshToken(refreshTokenRequest), HttpStatus.CREATED);
    }





}
