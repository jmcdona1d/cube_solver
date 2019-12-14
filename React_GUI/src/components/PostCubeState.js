import React from "react";
import {
  Button,
  Container,
  Form,
  FormGroup,
  Input,
  Label,
  Row,
  Col,
  Modal,
  ModalBody,
  ModalFooter,
  ModalHeader
} from "reactstrap";
import netDiagram from "../cubeAssets/Numbered_Net_Good.png";

export default class PostCubeState extends React.Component {
  emptyItem = {
    description: "desc",
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
      idToDelete: 0,
      white: "",
      red: "",
      blue: "",
      green: "",
      orange: "",
      yellow: "",
      showModal: false
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.resetDisplay = this.resetDisplay.bind(this);
    this.updateInputString = this.updateInputString.bind(this);
    this.openModal = this.openModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
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

    this.setState(
      {
        [name]: value
      },
      function() {
        this.updateInputString();
      }
    );
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

    const increment = this.state.idToDelete + 1;
    this.setState({
      solutionDisplayed: true,
      oneMade: true,
      idToDelete: increment
    });
    this.componentDidMount();
  }

  resetDisplay() {
    this.setState({ solutionDisplayed: false });
  }

  updateInputString() {
    var inputString =
      this.state.white +
      " " +
      this.state.red +
      " " +
      this.state.blue +
      " " +
      this.state.green +
      " " +
      this.state.orange +
      " " +
      this.state.yellow;
    var newItem = this.state.item;
    newItem.input = inputString;
    this.setState({ item: newItem });
  }

  openModal() {
    this.setState({ showModal: true });
  }

  closeModal() {
    this.setState({ showModal: false });
  }

  render() {
    const { item, groups } = this.state;
    const title = <h1>Enter Cube Details:</h1>;

    if (!this.state.solutionDisplayed) {
      return (
        <div>
          <Container>
            {title}
            <Form onSubmit={this.handleSubmit}>
              <Row>
                <Col>
                  <FormGroup>
                    <Label for="white">White Side</Label>
                    <Input
                      type="text"
                      name="white"
                      id="white"
                      value={this.state.white || ""}
                      onChange={this.handleChange}
                      autoComplete="white"
                    />
                  </FormGroup>
                </Col>
                <Col>
                  <FormGroup>
                    <Label for="red">Red Side</Label>
                    <Input
                      type="text"
                      name="red"
                      id="red"
                      value={this.state.red || ""}
                      onChange={this.handleChange}
                      autoComplete="red"
                    />
                  </FormGroup>
                </Col>
                <Col>
                  <FormGroup>
                    <Label for="blue">Blue Side</Label>
                    <Input
                      type="text"
                      name="blue"
                      id="blue"
                      value={this.state.blue || ""}
                      onChange={this.handleChange}
                      autoComplete="blue"
                    />
                  </FormGroup>
                </Col>
              </Row>
              <Row>
                <Col>
                  <FormGroup>
                    <Label for="green">Green Side</Label>
                    <Input
                      type="text"
                      name="green"
                      id="green"
                      value={this.state.green || ""}
                      onChange={this.handleChange}
                      autoComplete="green"
                    />
                  </FormGroup>
                </Col>
                <Col>
                  <FormGroup>
                    <Label for="orange">Orange Side</Label>
                    <Input
                      type="text"
                      name="orange"
                      id="orange"
                      value={this.state.orange || ""}
                      onChange={this.handleChange}
                      autoComplete="orange"
                    />
                  </FormGroup>
                </Col>
                <Col>
                  <FormGroup>
                    <Label for="yellow">Yellow Side</Label>
                    <Input
                      type="text"
                      name="yellow"
                      id="yellow"
                      value={this.state.yellow || ""}
                      onChange={this.handleChange}
                      autoComplete="yellow"
                    />
                  </FormGroup>
                </Col>
              </Row>
              {/* might need to make complet -> boolean or remove it since it is assigned */}
              <Row>
                <Col>
                  <FormGroup>
                    <Button color="primary" type="submit">
                      Create
                    </Button>{" "}
                    <Button color="secondary" onClick={this.openModal}>
                      View Instructions
                    </Button>{" "}
                  </FormGroup>
                </Col>
              </Row>
            </Form>
            <Modal isOpen={this.state.showModal} centered size="lg">
              <ModalHeader toggle={this.closeModal}>Instructions</ModalHeader>
              <ModalBody>
                <Container>
                  For each side, enter the colour letter (w,r,b,g,o,y) in order
                  (1 - 8) for each square. Afterwards, press <i>Create</i> to
                  see the steps needed to solve the cube. View the bellow
                  diagram to see order of squares.
                  <img src={netDiagram} />
                </Container>
              </ModalBody>
              <ModalFooter>
                <Button variant="secondary" onClick={this.closeModal}>
                  Close
                </Button>
              </ModalFooter>
            </Modal>
          </Container>
        </div>
      );
    } else {
      return (
        <div>
          <h1>Solving Instructions:</h1>
          {groups.map(group => (
            <div>
              <h3>
                <u>White Cross:</u>
              </h3>
              <div key={group.id}>{group.whiteCross}</div>

              <h3>
                <u>First Two Layers:</u>
              </h3>
              <div key={group.id}>{group.f2L}</div>

              <h3>
                <u>Orient Last Layer:</u>
              </h3>
              <div key={group.id}>{group.oll}</div>

              <h3>
                <u>Permute Last Layer:</u>
              </h3>
              <div key={group.id}>{group.pll}</div>

              <h3>
                <u>Align Last Layer:</u>
              </h3>
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
