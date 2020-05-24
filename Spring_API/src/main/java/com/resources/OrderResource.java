package com.resource;

import org.springframework.hateoas.ResourceSupport;

import com.domain.Order;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResource extends ResourceSupport {

	private final long id;
	private final String description;
	private final long costInCents;
	private final String[] result;
	private final boolean isComplete;
	private final boolean solved;
	private final String input;
	private final String whiteCross;
	private final String F2L;
	private final String PLL;
	private final String OLL;
	private final String finish;

	public OrderResource(Order order) {
		id = order.getId();
		description = order.getDescription();
		costInCents = order.getCostInCents();
		isComplete = order.isComplete();
		result = order.getResult();
		input = order.getInput();
		whiteCross = order.getWhiteCross();
		F2L = order.getF2L();
		PLL = order.getPLL();
		OLL = order.getOLL();
		finish = order.getFinish();
		solved = order.isSolved();
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

	public String getWhiteCross() {
		return whiteCross;
	}

	public String getF2L() {
		return F2L;
	}

	public String getPLL() {
		return PLL;
	}

	public String getOLL() {
		return OLL;
	}

	public String getFinish() {
		return finish;
	}

	public boolean isSolved() {
		return solved;
	}
}
