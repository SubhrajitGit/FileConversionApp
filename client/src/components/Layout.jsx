import React from "react";
import {Toaster} from "react-hot-toast"
import Header from "./Header";
import Footer from "./Footer";
Footer

const Layout = ({ children }) => {
  return (
    <>
      <Header/>
      <Toaster/>
      {children}
      <Footer/>
    </>
  );
};

export default Layout;
