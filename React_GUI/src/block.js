import React from "react";
import whiteBlock from "./cubeAssets/white_block.png";
import redBlock from "./cubeAssets/red_block.png";
import blueBlock from "./cubeAssets/blue_block.png";
import greenBlock from "./cubeAssets/green_block.png";
import orangeBlock from "./cubeAssets/orange_block.png";
import yellowBlock from "./cubeAssets/yellow_block.png";
import blankBlock from "./cubeAssets/coloured_blank_block.png";

import "./App.css";

export default class Block extends React.Component {
  state = { colourNum: -1 };

  constructor(props) {
    super(props);
    this.state.colourNum = props.colour;
  }

  render() {
    //console.log(this.state.colourNum);
    var blockStyle = {
      height: 50,
      width: 50
    };
    switch (this.state.colourNum) {
      case "0":
        return <img src={whiteBlock} alt="" style={blockStyle} />;

      case "1":
        return <img src={redBlock} alt="" style={blockStyle} />;

      case "2":
        return <img src={blueBlock} alt="" style={blockStyle} />;

      case "3":
        return <img src={greenBlock} alt="" style={blockStyle} />;

      case "4":
        return <img src={orangeBlock} alt="" style={blockStyle} />;

      case "5":
        return <img src={yellowBlock} alt="" style={blockStyle} />;

      default:
        return <img src={blankBlock} alt="" style={blockStyle} />;
    }
  }
}
