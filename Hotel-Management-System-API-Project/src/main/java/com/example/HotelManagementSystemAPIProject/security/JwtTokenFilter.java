package com.example.HotelManagementSystemAPIProject.security;

import com.example.HotelManagementSystemAPIProject.services.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CustomerDetailService customerDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String username = null;
        String jwtToken = null;


        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")){
            jwtToken = requestTokenHeader.substring(7);
            System.out.println("Getting token::"+jwtToken);

            try{
                username = this.jwtUtil.extractUsername(jwtToken);
                System.out.println("Username Extracted from Token::"+username);

            }catch(Exception e){
                e.printStackTrace();
            }

            UserDetails userDetails = this.customerDetailService.loadUserByUsername(username);
            System.out.println("Checking USerDetails Object::"+userDetails.getUsername());

            if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null){

                System.out.println("Inside Authentication Check.....");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                System.out.println("Validated token success !!!!");
            }else{
                System.out.println("Token is not validated");
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}






