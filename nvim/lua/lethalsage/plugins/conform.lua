return {
	"stevearc/conform.nvim",
	opts = {
		notify_on_error = false,
		-- format_on_save = function(bufnr)
		-- 	local disable_filetypes = {}
		-- 	return {
		-- 		timeout_ms = 500,
		-- 		lsp_fallback = not disable_filetypes[vim.bo[bufnr].filetype],
		-- 		async = false,
		-- 	}
		-- end,
		formatters_by_ft = {
			lua = { "stylua" },
			javascript = { "prettier" },
			typescript = { "prettier" },
			javascriptreact = { "prettier" },
			typescriptreact = { "prettier" },
			python = { "autopep8" },
			cpp = { "clang-format" },
			c = { "clang-format" },
		},
	},

	-- custom Format command
	vim.api.nvim_create_user_command("Format", function(args)
		local range = nil
		if args.count ~= -1 then
			local end_line = vim.api.nvim_buf_get_lines(0, args.line2 - 1, args.line2, true)[1]
			range = {
				start = { args.line1, 0 },
				["end"] = { args.line2, end_line:len() },
			}
		end
		require("conform").format({ async = true, lsp_fallback = true, range = range })
	end, { range = true }),
}
