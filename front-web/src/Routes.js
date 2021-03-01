import Autenticacao from "./Autenticacao";
import Principal from "./Principal";
import { BrowserRouter, Route } from "react-router-dom";

function Routes() {
  return (
    <BrowserRouter>
      {!localStorage.getItem("token") ? (
        <Autenticacao />
      ) : (
        <Route path="/" component={Principal} />
      )}
    </BrowserRouter>
  );
}

export default Routes;
