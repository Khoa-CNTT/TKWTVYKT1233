export const toSlug = (str) =>
  str
    .normalize("NFD") 
    .replace(/[\u0300-\u036f]/g, "") 
    .replace(/\s+/g, "-") 
    .toLowerCase(); 