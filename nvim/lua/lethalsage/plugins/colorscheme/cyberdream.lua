return {
	"scottmckendry/cyberdream.nvim",
	config = function()
		require("cyberdream").setup({
			transparent = true,
			italic_comments = true,
			hide_fillchars = true,
			borderless_telescope = false,
		})
		-- vim.cmd("colorscheme cyberdream")
		-- vim.cmd "colorscheme cyberdream"
	end,
}
