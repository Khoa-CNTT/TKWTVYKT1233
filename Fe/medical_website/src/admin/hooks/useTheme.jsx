import React, { useContext } from "react";

import { ThemeProviderContext } from "../contexts/theme_context";
export default function useTheme() {
  const context = useContext(ThemeProviderContext);

  if (context === undefined)
    throw new Error("useTheme must be used within a ThemeProvider");

  return context;
}
