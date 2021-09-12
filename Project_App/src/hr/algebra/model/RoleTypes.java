/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.Optional;

/**
 *
 * @author lcabraja
 */
public enum RoleTypes {

    Actor("Actor"),
    Director("Director");
    private final String name;

    private RoleTypes(String name) {
        this.name = name;
    }

    private static Optional<RoleTypes> from(String name) {
        for (RoleTypes value : values()) {
            if (value.name.equals(name)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
