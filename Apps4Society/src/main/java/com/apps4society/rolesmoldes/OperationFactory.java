package com.apps4society.rolesmoldes;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
public interface OperationFactory {
	void sleep(String method) throws InterruptedException;

}
