import logo from './logo.svg';
import './App.css';
import { Route, BrowserRouter as Router } from "react-router-dom";

class App extends Component {
  render() {
    return (
      <Router>
        <Route exact path="/" component={AccountList} />
        <Route exact path="/add" component={AddAccount} />
      </Router>
    )
  }
}

export default App;
