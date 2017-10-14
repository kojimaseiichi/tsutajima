package jp.tsutajima.people.repository;

import org.springframework.data.repository.CrudRepository;

import jp.tsutajima.poeple.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
