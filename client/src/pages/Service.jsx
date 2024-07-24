import React from 'react';
import Layout from '../components/Layout';

const Service = () => {
  return (
    <Layout>
      <div className="container mx-auto px-4 py-8">
        <h1 className="text-3xl font-bold mb-4">Our Services</h1>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          <div className="bg-white dark:bg-gray-900 shadow-md rounded-lg p-6">
            <h2 className="text-xl font-semibold mb-2">File Conversion</h2>
            <p className="text-gray-700">
              Convert various file formats including PDF, DOCX, and TXT to meet your needs.
            </p>
          </div>
          <div className="bg-white dark:bg-gray-900 shadow-md rounded-lg p-6">
            <h2 className="text-xl font-semibold mb-2">File Compression</h2>
            <p className="text-gray-700">
              Compress files to reduce storage size while maintaining quality and accessibility.
            </p>
          </div>
        </div>
      </div>
    </Layout>
  );
}

export default Service;
