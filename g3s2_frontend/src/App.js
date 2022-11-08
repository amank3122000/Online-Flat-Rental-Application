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
        <Route exact path="/" element={<Home />}/>
        <Route path="/login" element={<Login />}/>
        <Route path="/loginactions" element={<LoginAction />}/>
        <Route exact path="/admin" element={<AdminPage />}/>
        <Route exact path="/tenant" element={<Tenant />}/>
        <Route exact path="/landlord" element={<LandLord />}/>
        <Route element={<NotFoundPage />}/>
      </Routes>

    </Router>

  );
}

export default App;
