package fr.cmm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
/**
 * Created by pomme on 18/12/2015.
 */
public class ResourceNotFoundException extends Throwable {
}
