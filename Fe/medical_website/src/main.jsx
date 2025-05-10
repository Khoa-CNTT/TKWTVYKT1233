import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "./App.jsx";
import { BrowserRouter } from "react-router-dom";
import AppContextProvider from "./context/AppContext";
import AppAdmin from "./admin/Routes/AppAdmin.jsx";

createRoot(document.getElementById("root")).render(
  <BrowserRouter>
    {/* <AppContextProvider>
      <App />
    </AppContextProvider> */}
    <AppAdmin />
  </BrowserRouter>
);
