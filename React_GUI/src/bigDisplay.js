import React from "react";
import Block from "./block";
import GridLayout from "react-grid-layout";

import "react-grid-layout/css/styles.css";
import "react-resizable/css/styles.css";

export default class BigDisplay extends React.Component {
  state = { allColour: -1 };

  constructor(props) {
    super(props);
    this.state.colour = props.colour;
    this.state.c1 = props.c1;
    this.state.c2 = props.c2;
    this.state.c3 = props.c3;
    this.state.c4 = props.c4;
    this.state.c5 = props.c5;
    this.state.c6 = props.c6;
    this.state.c7 = props.c7;
    this.state.c8 = props.c8;
  }
  render() {
    return (
      <div>
        <div>
          <Block colour={this.state.c1} />
          <Block colour={this.state.c2} />
          <Block colour={this.state.c3} />
        </div>
        <div>
          <Block colour={this.state.c4} />
          <Block colour={this.state.colour} />
          <Block colour={this.state.c5} />
        </div>
        <div>
          <Block colour={this.state.c6} />
          <Block colour={this.state.c7} />
          <Block colour={this.state.c8} />
        </div>
      </div>
    );
  }
}
