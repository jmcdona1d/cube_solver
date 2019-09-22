import React from "react";
import ReactDOM from "react-dom";
import BigDisplay from "./bigDisplay";
import GridLayout from "react-grid-layout";

import "react-grid-layout/css/styles.css";
import "react-resizable/css/styles.css";
import "./App.css";

export default class NetLayout extends React.Component {
  render() {
    return (
      <div>
        <BigDisplay
          colour="0"
          c1="0"
          c2="0"
          c3="0"
          c4="0"
          c5="0"
          c6="0"
          c7="0"
          c8="0"
        />
        <BigDisplay
          colour="1"
          c1="1"
          c2="1"
          c3="1"
          c4="1"
          c5="1"
          c6="1"
          c7="1"
          c8="1"
        />
        <BigDisplay
          colour="2"
          c1="2"
          c2="2"
          c3="2"
          c4="2"
          c5="2"
          c6="2"
          c7="2"
          c8="2"
        />
        <BigDisplay
          colour="3"
          c1="3"
          c2="3"
          c3="3"
          c4="3"
          c5="3"
          c6="3"
          c7="3"
          c8="3"
        />
        <BigDisplay
          colour="4"
          c1="4"
          c2="4"
          c3="4"
          c4="4"
          c5="4"
          c6="4"
          c7="4"
          c8="4"
        />
        <BigDisplay
          colour="5"
          c1="5"
          c2="5"
          c3="5"
          c4="5"
          c5="5"
          c6="5"
          c7="5"
          c8="5"
        />
      </div>
    );
  }
}
ReactDOM.render(<NetLayout />, document.getElementById("root"));
