import Footer from "./Footer";
import Home from "./Home";
import NavBar from "./NavBar";


function App() {

  // console.log(localStorage.getItem("token"));

  // if (!localStorage.getItem("token")) {
  //   window.location.href="https://www.google.com"
  //   return;
  // }
  return (
    <div className="App">
      <>
        <NavBar />
        <Home />
        <Footer />
      </>
    </div>
  );
}

export default App;
