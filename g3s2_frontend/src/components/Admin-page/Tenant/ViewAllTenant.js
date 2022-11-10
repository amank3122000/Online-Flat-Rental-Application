import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllTenant() {

    let initialCustomers=[];
    let [tenants,setTenants]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/tenant/gettenants';
        axios.get(URL).then((response) => {
            setTenants(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

     function goToAddCustomer(){
    //     //props.history.push('/addCustomer');
     }


  return (
      <React.Fragment>
            <table className="table table-data table-striped table-bordered">
    <thead>
        <tr className="table-warning">
          <th className="col-md-2">ID</th>
          <th className="col-md-3">Tenant Name</th>
          <th className="col-md-1">Age</th>
          <th className="col-md-3">Flat List</th>
          <th className="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody className="table-success ">
      {
                tenants.map (
                    tenant =>
        <tr>
          <td className="col-md-2">{tenant.tenantId}</td>
          <td className="col-md-3">{tenant.tenantName}</td>
          <td className="col-md-1">{tenant.age}</td>
          <td className="col-md-3">
            <button className="btn btn-info logout-btn" type="submit">Flat List</button>
          </td>
          <td class="col-md-3">
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      
                )}
      </tbody>

  </table> 
    </React.Fragment>
    );
}

export default ViewAllTenant;