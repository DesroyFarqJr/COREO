package com.coreo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   private int id;
   private String username;
   private String email;
   @JsonIgnore
   private String password;
   private String profilePicture;
   private String bio;
   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();

   public User() { }

   public User(int id, String username, String email, String password, String profilePicture, String bio, String authorities) {
      this.id = id;
      this.username = username;
      this.email = email;
      this.password = password;
      this.profilePicture = profilePicture;
      this.bio = bio;
      if(authorities != null) this.setAuthorities(authorities);
      this.activated = true;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getProfilePicture() {
      return profilePicture;
   }

   public void setProfilePicture(String profilePicture) {
      this.profilePicture = profilePicture;
   }

   public String getBio() {
      return bio;
   }

   public void setBio(String bio) {
      this.bio = bio;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(email, user.email) &&
              Objects.equals(password, user.password) &&
              Objects.equals(profilePicture, user.profilePicture) &&
              Objects.equals(bio, user.bio) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, email, password, profilePicture, bio, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", email='" + email + '\'' +
              ", activated=" + activated +
              ", profilePicture='" + profilePicture +
              ", bio='" + bio +
              ", authorities=" + authorities +
              '}';
   }
}
