import org.codehaus.jackson.annotate.JsonProperty;

public class OrderResource extends org.springframework.hateoas.ResourceSupport{

	
	private final long id;
	private final String description;
	private final long costInCents;
	private final boolean isComplete;
	
	public OrderResource(Order order) {
		id = order.getId();
		description = order.getDescription();
		costInCents = order.getCostInCents();
		isComplete = order.isComplete();
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
}
