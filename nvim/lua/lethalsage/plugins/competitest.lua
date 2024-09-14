return {
	"xeluxee/competitest.nvim",
	dependencies = "MunifTanjim/nui.nvim",
	config = function()
		require("competitest").setup({
			runner_ui = {
				interface = "split",
			},
			split_ui = {
				position = "right",
				relative_to_editor = true,
				total_width = 0.4,
				vertical_layout = {
					{ 1, "tc" },
					{ 1, { { 1, "so" }, { 1, "eo" } } },
					{ 1, { { 1, "si" }, { 1, "se" } } },
				},
				total_height = 0.4,
				horizontal_layout = {
					{ 2, "tc" },
					{ 3, { { 1, "so" }, { 1, "si" } } },
					{ 3, { { 1, "eo" }, { 1, "se" } } },
				},
			},
			template_file = {
				cpp = "~/.config/nvim/lua/lethalsage/snippets/template.cpp",
			},
		})
	end,
}
