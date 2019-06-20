export const getProjectsMock = () => ({
  projects: [
    {
      id: "p1",
      name: "Boden",
      owner: "Sven Johnson",
      dateModified: "06/04/2019",
      workspaces: [
        {
          id: "w1",
          name: "Product Detail Page",
          owner: "Sven Johnson",
          dateModified: "06/04/2019"
        },
        {
          id: "w2",
          name: "Product Listing Page",
          owner: "Sven Johnson",
          dateModified: "06/04/2019"
        },
        {
          id: "w3",
          name: "Checkout Upgrade",
          owner: "Sven Johnson",
          dateModified: "06/04/2019"
        }
      ]
    },
    {
      id: "p2",
      name: "Unilever",
      owner: "Donna Smith",
      dateModified: "20/06/2019",
      workspaces: [
        {
          id: "w4",
          name: "Search Results",
          owner: "Sven Johnson",
          dateModified: "06/04/2019"
        },
        {
          id: "w5",
          name: "Landing Page Upgrades",
          owner: "Sven Johnson",
          dateModified: "06/04/2019"
        }
      ]
    }
  ]
});
