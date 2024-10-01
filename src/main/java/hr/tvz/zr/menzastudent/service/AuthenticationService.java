package hr.tvz.zr.menzastudent.service;

import hr.tvz.zr.menzastudent.model.*;

public interface AuthenticationService {
    UserAuthResponse authenticate(UserAuthRequest request);
    User signUp(SignUpRequest signUpRequest);
    UserAuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
