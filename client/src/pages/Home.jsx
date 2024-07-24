import React, { useState } from 'react';
import Layout from '../components/Layout';
import axios from 'axios';

const Home = () => {
  const [fromFormat, setFromFormat] = useState('');
  const [toFormat, setToFormat] = useState('');
  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileChange = (e) => {
    setSelectedFile(e.target.files[0]);
  };

  const handleConvert = async () => {
    if (!fromFormat || !toFormat || !selectedFile) {
      alert('Please select From Format, To Format, and upload a file.');
      return;
    }

    const formData = new FormData();
    formData.append('file', selectedFile);
    formData.append('format', toFormat);

    try {
      const response = await axios.post('http://localhost:8080/api/v1/file-conversion/convert', formData, {
        responseType: 'blob' // Ensure response type is set to blob for file download
      });

      // Handle the file download
      const downloadUrl = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement('a');
      link.href = downloadUrl;
      link.setAttribute('download', `CONVERTED.${toFormat}`);
      document.body.appendChild(link);
      link.click();
      link.remove();
    } catch (error) {
      console.error('File conversion error:', error);
      alert('File conversion failed. Please try again.');
    }
  };

  return (
    <Layout>
      <div className="min-h-screen flex items-center justify-center bg-gray-100">
        <div className="bg-white p-8 shadow-md rounded-lg max-w-lg w-full">
          <h1 className="text-3xl font-bold text-center mb-8">File Converter</h1>
          <div className="flex justify-between mb-4">
            <div className="w-1/2 mr-2">
              <label htmlFor="fromFormat" className="block text-sm font-medium text-gray-700 mb-2">From Format</label>
              <select
                id="fromFormat"
                name="fromFormat"
                className="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                value={fromFormat}
                onChange={(e) => setFromFormat(e.target.value)}
              >
                <option value="">Select Format</option>
                <option value="pdf">PDF</option>
                <option value="docx">DOCX</option>
                <option value="txt">TXT</option>
                <option value="csv">CSV</option> {/* Added CSV option */}
              </select>
            </div>
            <div className="w-1/2 ml-2">
              <label htmlFor="toFormat" className="block text-sm font-medium text-gray-700 mb-2">To Format</label>
              <select
                id="toFormat"
                name="toFormat"
                className="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                value={toFormat}
                onChange={(e) => setToFormat(e.target.value)}
              >
                <option value="">Select Format</option>
                <option value="pdf">PDF</option>
                <option value="xls">XLS</option>
                <option value="txt">TXT</option>
              </select>
            </div>
          </div>
          <div className="mb-8">
            <label htmlFor="fileUpload" className="block text-sm font-medium text-gray-700 mb-2">Choose File</label>
            <div className="flex items-center justify-center bg-gray-200 rounded-md py-2 px-4 border border-gray-300 hover:bg-gray-300 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
              <label className="relative cursor-pointer">
                <span className="text-indigo-600">Upload a file</span>
                <input
                  id="fileUpload"
                  name="fileUpload"
                  type="file"
                  className="sr-only"
                  onChange={handleFileChange}
                />
              </label>
            </div>
          </div>
          <button
            type="button"
            className="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
            onClick={handleConvert}
          >
            Convert File
          </button>
        </div>
      </div>
    </Layout>
  );
};

export default Home;
