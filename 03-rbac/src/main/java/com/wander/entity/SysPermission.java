package com.wander.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class SysPermission {
    /**
     * 权限ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称（如查询用户、删除订单）
     */
    private String permName;

    /**
     * 权限编码（如user:query, order:delete）
     */
    private String permCode;

    /**
     * 资源类型（API：接口，MENU:菜单）
     */
    private String resourceType;

    /**
     * 资源路径（例如：/admin/**, /user/info）
     */
    private String resourcePath;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysPermission other = (SysPermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPermName() == null ? other.getPermName() == null : this.getPermName().equals(other.getPermName()))
            && (this.getPermCode() == null ? other.getPermCode() == null : this.getPermCode().equals(other.getPermCode()))
            && (this.getResourceType() == null ? other.getResourceType() == null : this.getResourceType().equals(other.getResourceType()))
            && (this.getResourcePath() == null ? other.getResourcePath() == null : this.getResourcePath().equals(other.getResourcePath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPermName() == null) ? 0 : getPermName().hashCode());
        result = prime * result + ((getPermCode() == null) ? 0 : getPermCode().hashCode());
        result = prime * result + ((getResourceType() == null) ? 0 : getResourceType().hashCode());
        result = prime * result + ((getResourcePath() == null) ? 0 : getResourcePath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", permName=").append(permName);
        sb.append(", permCode=").append(permCode);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", resourcePath=").append(resourcePath);
        sb.append("]");
        return sb.toString();
    }
}