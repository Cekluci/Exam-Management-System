import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import ListExamsForTeachersComponent from './components/ListExamsForTeachersComponent';
import CreateExamComponent from './components/CreateExamComponent';
import UpdateExamComponent from './components/UpdateExamComponent';

function App() {
  return (
    <div className="App">
      <Router>
        <HeaderComponent />
        <div className='container'>
          <Routes>
            <Route path = '/' exact Component={ListExamsForTeachersComponent}></Route>
            <Route path = '/create-exam' exact Component={CreateExamComponent}></Route>
            <Route path = '/update-exam/:id' exact  Component={UpdateExamComponent}></Route>
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
