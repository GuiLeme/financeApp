import './App.css';
import Header from './components/Header';
import SideBar from './components/SideBar';
import Table from './components/Table';

function App() {
  return (<>
      <Header/>
      <div className='container'>
        <SideBar/>
        <Table/>
      </div>
      
  </>
  );
}

export default App;
