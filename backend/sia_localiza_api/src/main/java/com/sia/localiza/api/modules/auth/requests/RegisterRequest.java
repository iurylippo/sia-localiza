package com.sia.localiza.api.modules.auth.requests;


import com.sia.localiza.api.common.annotations.validation.constraints.RoleType;
import com.sia.localiza.api.modules.users.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
  @NotNull
  @NotBlank
  private String name;

  @NotNull
  @NotBlank
  private String email;

  @NotNull
  @NotBlank
  private String password;
  
  @RoleType(anyOf =  {Role.ADMIN, Role.MANAGER, Role.USER})
  @NotNull
  private Role role;
}
