import React from "react";
import { Button, Container, Form, FormGroup, Input, Label } from "reactstrap";

export default class PostCubeState extends React.Component {
  emptyItem = {
    description: "",
    costInCents: "",
    complete: "",
    result: ""
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  //   async componentDidMount() {
  //     if (this.props.match.params.id !== "new") {
  //       const cube = await (
  //         await fetch(`/order/${this.props.match.params.id}`)
  //       ).json();
  //       this.setState({ item: cube });
  //     }
  //   }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = { ...this.state.item };
    item[name] = value;
    this.setState({ item });
  }

  async handleSubmit(event) {
    event.preventDefault();
    const { item } = this.state;

    await fetch("/order", {
      method: item.id ? "PUT" : "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(item)
    });
    // this.props.history.push('/order');
    window.location.reload();
  }

  render() {
    const { item } = this.state;
    const title = <h2>Create cube</h2>;

    return (
      <div>
        <Container>
          {title}
          <Form onSubmit={this.handleSubmit}>
            <FormGroup>
              <Label for="description">Description</Label>
              <Input
                type="text"
                name="description"
                id="description"
                value={item.description || ""}
                onChange={this.handleChange}
                autoComplete="description"
              />
            </FormGroup>
            <FormGroup>
              <Label for="costInCents">Cost in Cents</Label>
              <Input
                type="number"
                name="costInCents"
                id="costInCents"
                value={item.costInCents || ""}
                onChange={this.handleChange}
                autoComplete="costInCents"
              />
            </FormGroup>
            <FormGroup>
              <Label for="complete">Complete</Label>
              <Input
                type="text"
                name="complete"
                id="complete"
                value={item.complete || ""}
                onChange={this.handleChange}
                autoComplete="complete"
              />
            </FormGroup>
            <FormGroup>
              <Label for="result">Result</Label>
              <Input
                type="text"
                name="result"
                id="result"
                value={item.result || ""}
                onChange={this.handleChange}
                autoComplete="result"
              />
            </FormGroup>
            {/* might need to make complet -> boolean or remove it since it is assigned */}
            <FormGroup>
              <Button color="primary" type="submit">
                Create
              </Button>{" "}
            </FormGroup>
          </Form>
        </Container>
      </div>
    );
  }
}
