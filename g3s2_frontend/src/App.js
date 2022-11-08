import './App.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route} from "react-router-dom"

import Home from './components/Home-Page/Home';
import Login from './components/Login-Page/Login';
import NotFoundPage from './components/NotFoundPage';
 
import AdminPage from './components/Admin-page/AdminPage/AdminPage';
import LandLord from './components/Landlord-page/LandlordPage';
import Tenant from './components/Tenant-page/TenantPage';
import LoginAction from './components/Login-Page/LoginAction';





function App() {
  return (
    
    <Router>

      <Routes>
        <Route exact path="/" component = {Home}/>
        <Route path="/login" component = {Login}/>
        <Route path="/loginactions" component = {LoginAction}/>
        <Route exact path="/admin" component = {AdminPage}/>
        <Route exact path="/tenant" component = {Tenant}/>
        <Route exact path="/landlord" component = {LandLord}/>
        <Route component={NotFoundPage}/>
      </Routes>

    </Router>
     
  );
}

export default App;
