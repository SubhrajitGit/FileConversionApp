import React from 'react';
import {NavLink} from "react-router-dom"

const Header = () => {
  return (
    <header className="bg-blue-500 py-4">
      <div className="container mx-auto flex justify-between items-center">
        <div className="text-white text-xl font-semibold">File Converter</div>
        <nav className="space-x-4">
          <NavLink to="/" className="text-white hover:text-blue-200">Home</NavLink>
          <NavLink to="/about" className="text-white hover:text-blue-200">About</NavLink>
          <NavLink to="/services" className="text-white hover:text-blue-200">Services</NavLink>
          <NavLink to="/contact" className="text-white hover:text-blue-200">Contact</NavLink>
          <NavLink to="/registration" className="text-white hover:text-blue-200">Register</NavLink>
          <NavLink to="/log-in" className="text-white hover:text-blue-200">Log-In</NavLink>
        </nav>
      </div>
    </header>
  );
}

export default Header;
