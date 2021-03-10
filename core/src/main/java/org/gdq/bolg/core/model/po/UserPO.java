package org.gdq.bolg.core.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @author God_q1
 * date 2020/7/7
 * description user_item Table
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPO extends BasePO implements UserDetails {
    // 账号
    private String  username;
    // 密码
    private String  password;
    // 锁
    private boolean lock;
    // 账号过期时间 - null = never
    private Date    accountExpires;
    // 密码过期时间 - null = never
    private Date    credentialExpires;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountExpires == null || new Date().compareTo(this.accountExpires) < 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.lock;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialExpires == null || new Date().compareTo(this.credentialExpires) < 0;
    }

    @Override
    public boolean isEnabled() {
        return isAccountNonExpired() && isAccountNonLocked() && isCredentialsNonExpired();
    }
}
