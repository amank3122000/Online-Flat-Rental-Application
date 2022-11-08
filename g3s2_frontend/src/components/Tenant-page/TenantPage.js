import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';

import Home from '../Tenant-page/Home';
import Header from '../Tenant-page/Header';
import Menu from '../Tenant-page/Menu';
import GetAllFlats from '../Tenant-page/GetAllFlats';
import ViewFlatByBid from '../Tenant-page/ViewFlatByBid';
import UpdateBooking from '../Tenant-page/UpdateBooking';
import AddFlatBooking from '../Tenant-page/AddFlatBooking';
import Footer from '../Tenant-page/Footer';




function Tenant() {

   return (
      <React.Fragment>
            {/* <Router> */}
              
    <div className="container mt-2">
      {/* <AddFlatBooking /> */}
      <Header />
      <Menu />  
      <Routes>
      <Route path="/tenant" exact element={<Home />} />
      <Route path="/getallflats" exact element={<GetAllFlats />} />
      <Route path="/viewflatbybid" exact element={<ViewFlatByBid />} />
      <Route path="/updatebooking" exact element={<UpdateBooking />} />
      <Route path="/addbooking" exact element={<AddFlatBooking />} />
      </Routes>
      <Footer />
    </div>

    {/* </ Router> */}
      </React.Fragment>
    );
}

export default Tenant;