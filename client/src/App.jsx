import React from 'react'
import Registration from './pages/Registration'
import Home from './pages/Home'
import Layout from './components/Layout'
import {Routes,Route} from "react-router-dom"
import About from './pages/About'
import Service from './pages/Service'
import Contact from './pages/ContactUs'
import Login from './pages/Login'

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/about" element={<About/>}/>
        <Route path="/services" element={<Service/>}/>
        <Route path="/contact" element={<Contact/>}/>
        <Route path="/registration" element={<Registration/>}/>
        <Route path="/log-in" element={<Login/>}/>
      </Routes>
    </>
  )
}

export default App
