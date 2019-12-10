package com.dzone.albanoj2.example.rest.resource;

import org.springframework.hateoas.ResourceSupport;

import com.dzone.albanoj2.example.rest.domain.Order;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResource extends ResourceSupport {

	private final long id;
	private final String description;
	private final long costInCents;
	private final String[] result;
	private final boolean isComplete;
	private final String input;
	private final String firstSet;

	public OrderResource(Order order) {
		id = order.getId();
		description = order.getDescription();
		costInCents = order.getCostInCents();
		isComplete = order.isComplete();
		result = order.getResult();
		input = order.getInput();
		firstSet = order.getFirstSet();
	}

	@JsonProperty("id")
	public Long getResourceId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public long getCostInCents() {
		return costInCents;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public String[] getResult() {
		return result;
	}

	public String getInput() {
		return input;
	}

	public String getFirstSet() {
		return firstSet;
	}
}
