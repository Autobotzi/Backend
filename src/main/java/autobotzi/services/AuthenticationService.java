package autobotzi.services;

import autobotzi.dto.JwtAuthenticationResponse;
import autobotzi.dto.RefreshTokenRequest;
import autobotzi.dto.SignInRequest;
import autobotzi.dto.SignUpRequest;
import autobotzi.organizations.util.OrganizationsDto;
import autobotzi.user.Users;

public interface AuthenticationService {
    Users signUpUser(SignUpRequest user);

    Users SignUpAdmin(SignUpRequest user, OrganizationsDto organizationsDto);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}