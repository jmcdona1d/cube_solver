import React from "react";
import { Button, Container, Form, FormGroup, Input, Label } from "reactstrap";

export default class PostCubeState extends React.Component {
  emptyItem = {
    description: "",
    costInCents: "",
    complete: "",
    input: ""
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem,
      groups: [],
      solutionDisplayed: false,
      oneMade: false,
      idToDelete: 0
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.resetDisplay = this.resetDisplay.bind(this);
  }

  async componentDidMount() {
    const response = await fetch("/order");
    const body = await response.json();
    this.setState({ groups: body, isLoading: false });
  }

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
    const { item, oneMade, idToDelete } = this.state;

    await fetch(`/order/${idToDelete}`, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      }
    }).then(() => {
      let updatedGroups = [...this.state.groups].filter(
        i => i.id !== idToDelete
      );
      this.setState({ groups: updatedGroups });
    });

    await fetch("/order", {
      method: item.id ? "PUT" : "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(item)
    });
    // this.props.history.push('/order');
    const increment = this.state.idToDelete + 1;
    this.setState({
      solutionDisplayed: true,
      oneMade: true,
      idToDelete: increment
    });
    this.componentDidMount();
    //window.location.reload();
  }

  resetDisplay() {
    this.setState({ solutionDisplayed: false });
  }

  render() {
    const { item, groups } = this.state;
    const title = <h2>Create cube</h2>;

    if (!this.state.solutionDisplayed) {
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
                <Label for="input">Input state</Label>
                <Input
                  type="text"
                  name="input"
                  id="input"
                  value={item.input || ""}
                  onChange={this.handleChange}
                  autoComplete="input"
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
    } else {
      return (
        <div>
          <h2>Solving Instructions:</h2>
          {groups.map(group => (
            <div>
              <h3>White Cross:</h3>
              <div key={group.id}>{group.whiteCross}</div>

              <h3>First Two Layers:</h3>
              <div key={group.id}>{group.f2L}</div>

              <h3>Orient Last Layer:</h3>
              <div key={group.id}>{group.oll}</div>

              <h3>Permute Last Layer:</h3>
              <div key={group.id}>{group.pll}</div>

              <h3>Align Final Layer:</h3>
              <div key={group.id}>{group.finish}</div>
            </div>
          ))}
          <Button color="primary" onClick={this.resetDisplay}>
            Return
          </Button>
        </div>
      );
    }
  }
}
