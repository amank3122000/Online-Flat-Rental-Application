import React, { useState } from 'react';
import axios from 'axios';
import styles from '../Login-Page/login.module.css';
import { Link } from 'react-router-dom';

function Register() {

    return (
    <React.Fragment>
        <div className={styles.reg}>
            <button id="formlogin" className={styles.btnreg}><Link to='/registerTenant'>Register as Tenant</Link></button>
            <button id="formlogin" className={styles.btnreg}><Link to='/registerLandlord'>Register as Landlord</Link></button>
            </div>
    </React.Fragment>
  )
}

export default Register