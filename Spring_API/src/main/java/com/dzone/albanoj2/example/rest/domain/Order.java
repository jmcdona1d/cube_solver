package com.dzone.albanoj2.example.rest.domain;

public class Order implements Identifiable {

	private Long id;
	private String description;
	private long costInCents;
	private boolean isComplete;
	private String input;
	private String[] result;
	private String whiteCross;
	private String F2L;
	private String OLL;
	private String PLL;
	private String finish;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCostInCents(long cost) {
		costInCents = cost;
	}

	public long getCostInCents() {
		return costInCents;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public void markComplete() {
		setComplete(true);
	}

	public void markIncomplete() {
		setComplete(false);
	}

	public boolean isComplete() {
		return isComplete;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		String set = (input == null || input.length() < 52) ? "52122200 01445432 34213553 20445145 01413130 30102355"
				: input;
		this.input = set;
		Cube c = new Cube(this.input);
		int j = c.solveCube();
		String[] instructions = c.getSolveInstructionsArray();
		setResult(instructions);
		setWhiteCross(instructions[0]);
		setF2L(instructions[1]);
		setPLL(instructions[2]);
		setOLL(instructions[3]);
		setFinish(instructions[4]);
	}

	public String[] getResult() {
		return result;
	}

	public void setResult(String[] result) {
		this.result = result;
	}

	public void setWhiteCross(String whiteCross) {
		this.whiteCross = whiteCross;
	}

	public String getWhiteCross() {
		return this.whiteCross;
	}

	public void setF2L(String F2L) {
		this.F2L = F2L;
	}

	public String getF2L() {
		return this.F2L;
	}

	public void setOLL(String OLL) {
		this.OLL = OLL;
	}

	public String getOLL() {
		return this.OLL;
	}

	public void setPLL(String PLL) {
		this.PLL = PLL;
	}

	public String getPLL() {
		return this.PLL;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public String getFinish() {
		return this.finish;
	}
}
