import React from 'react';
import Layout from '../components/Layout';

const About = () => {
  return (
    <Layout>
      <div className="container mx-auto px-4 py-8">
        <h1 className="text-3xl font-bold mb-4">About Us</h1>
        <p className="text-lg text-gray-700 mb-4">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam vel metus vel leo consectetur faucibus. Mauris auctor lorem a velit iaculis, ac viverra nulla sodales. Nullam at libero ac orci efficitur ullamcorper.
        </p>
        <p className="text-lg text-gray-700 mb-4">
          Fusce euismod augue non velit lacinia, vitae dapibus nunc vestibulum. Donec vehicula purus id orci ullamcorper, at efficitur lorem suscipit. Mauris commodo, justo nec eleifend faucibus, est nulla consectetur risus.
        </p>
        <p className="text-lg text-gray-700 mb-4">
          Integer nec ex eu ligula blandit finibus ut a tellus. Sed sed tincidunt nisl. Aliquam ac tellus vehicula, fermentum ipsum non, accumsan nisi.
        </p>
      </div>
    </Layout>
  );
}

export default About;
