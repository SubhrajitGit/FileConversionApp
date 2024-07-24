// Footer.js

import React from 'react';

const Footer = () => {
  return (
    <footer className="bg-gray-900 text-gray-300 mt-16 py-6">
      <div className="container mx-auto flex justify-between items-center">
        <div className="text-white text-sm">&copy; 2024 File Converter App. All rights reserved.</div>
        <div className="flex space-x-4">
          <a href="#" className="text-gray-300 hover:text-white">Privacy Policy</a>
          <a href="#" className="text-gray-300 hover:text-white">Terms of Service</a>
          <a href="#" className="text-gray-300 hover:text-white">Contact Us</a>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
