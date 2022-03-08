package com.mbmosman.model;

public class NotAuthorizedException extends Exception {

    public NotAuthorizedException() {
        super("Not authorized for this operation.");
    }

}
