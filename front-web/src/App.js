import Routes from "./Routes";


function App() {

  // console.log(localStorage.getItem("token"));

  // if (!localStorage.getItem("token")) {
  //   window.location.href="https://www.google.com"
  //   return;
  // }
  return (
    <div className="App">
      <>
        <Routes />
      </>
    </div>
  );
}

export default App;
