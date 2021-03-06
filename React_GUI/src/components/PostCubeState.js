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
      idToDelete: 0,
      white: "",
      red: "",
      blue: "",
      green: "",
      orange: "",
      yellow: "",
      showModal: false,
      deadRun: false
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.resetDisplay = this.resetDisplay.bind(this);
    this.updateInputString = this.updateInputString.bind(this);
    this.openModal = this.openModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
    this.solveWorked = this.solveWorked.bind(this);
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
    const { item, idToDelete } = this.state;

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
      idToDelete: increment
    });
    this.componentDidMount();
    this.solveWorked();
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

  solveWorked() {
    this.state.groups.map(group => this.setState({ deadRun: group.solved }));
  }

  render() {
    const { groups } = this.state;
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
                      maxLength="8"
                      minLength="8"
                      required="true"
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
                      maxLength="8"
                      minLength="8"
                      required="true"
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
                      maxLength="8"
                      minLength="8"
                      required="true"
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
                      maxLength="8"
                      minLength="8"
                      required="true"
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
                      maxLength="8"
                      minLength="8"
                      required="true"
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
                      maxLength="8"
                      minLength="8"
                      required="true"
                    />
                  </FormGroup>
                </Col>
              </Row>
              {/* might need to make complete -> boolean or remove it since it is assigned */}
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
                  <p>
                    For each face, enter the colour letter or number in order (1
                    - 8) for each square. Afterwards, press <i>Create</i> to see
                    the steps needed to solve the cube.{" "}
                  </p>
                  <uL>
                    <li> w or 0 represent white</li>
                    <li> r or 1 represent red</li>
                    <li> b or 2 represent blue</li>
                    <li> g or 3 represent green</li>
                    <li> o or 4 represent orange</li>
                    <li> y or 5 represent yellow</li>
                  </uL>
                  <p>
                    View the bellow diagram to see order of squares.
                    <img src={netDiagram} alt="Diagram of Cube Net" />
                  </p>
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
    } else if (!this.state.deadRun) {
      return (
        <div>
          <h1>Solving Instructions:</h1>

          <Container>
            {groups.map(group => (
              <div>
                <Row>
                  <h3>
                    <u>White Cross:</u>
                  </h3>
                </Row>

                <Row>
                  <div key={group.id}>{group.whiteCross}</div>
                </Row>

                <Row>
                  <h3>
                    <u>First Two Layers:</u>
                  </h3>
                </Row>
                <Row>
                  <div key={group.id}>{group.f2L}</div>
                </Row>
                <Row>
                  <h3>
                    <u>Orient Last Layer:</u>
                  </h3>
                </Row>
                <Row>
                  <div key={group.id}>{group.oll}</div>
                </Row>
                <Row>
                  <h3>
                    <u>Permute Last Layer:</u>
                  </h3>
                </Row>
                <Row>
                  <div key={group.id}>{group.pll}</div>
                </Row>
                <Row>
                  <h3>
                    <u>Align Last Layer:</u>
                  </h3>
                </Row>
                <Row>
                  <div key={group.id}>{group.finish}</div>
                </Row>
              </div>
            ))}
            <Row>
              <Col>
                <Button color="primary" onClick={this.resetDisplay}>
                  Return
                </Button>
              </Col>
              <Col>
                <Button color="secondary" onClick={this.openModal}>
                  Help
                </Button>
              </Col>
            </Row>
            <Modal isOpen={this.state.showModal} centered size="lg">
              <ModalHeader toggle={this.closeModal}>Help</ModalHeader>
              <ModalBody>
                <Container>
                  <p>
                    Sequentially follow the instructions from top to bottom.
                    Each character says which face you should turn - if there is
                    a space after it then turn the face clockwise and if there
                    is a <i>`</i> after it then turn the face counter-clockwise{" "}
                  </p>
                  <ul>
                    <li>
                      After doing the <i>White Cross</i> instructions there
                      should be a cross fromed with the edges on the white face
                    </li>
                    <li>
                      After doing the <i>First Two Layers</i> instructions the
                      first two layers - white and the middle layer should be
                      solved
                    </li>
                    <li>
                      After doing the <i>Orient Last Layer</i> instructions the
                      yellow layer should have all the correct squares facing up
                    </li>
                    <li>
                      After doing the <i>Permute Last Layer</i> instructions the
                      yellow layer should have all the corners placed correctly
                    </li>
                    <li>
                      After doing the <i>Align Last Layer</i> instructions the
                      cube should be solved!
                    </li>
                  </ul>
                  <i>
                    If a set is blank then it should not need any actions to
                    complete and can be skipped
                  </i>
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
          <h1>The inputted cube state could not be solved.</h1>
          <h2>Please click bellow to re-enter/fix the cube input</h2>
          <Button color="primary" onClick={this.resetDisplay}>
            Return
          </Button>
        </div>
      );
    }
  }
}
